package com.fluig.junit5.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BankAccountTestNested {


    @Test()
    @DisplayName("credit works")
    void testCredit() {
        BankAccount acct = new BankAccount(100, 0);
        acct.credit(50);
        assertEquals(150, acct.getBalance());
    }

    @Nested
    @DisplayName("debt works")
    class DebtScenarios {

        @Nested
        @DisplayName("without overdraft protection")
        class NoOverdraftProtection {
            @Test()
            @DisplayName("debit < balance")
            void testDebt_NoOverdraftProtection_DebtLTBalance() {
                BankAccount acct = new BankAccount(100, 0);
                boolean success = acct.debt(50);
                assertTrue(success);
                assertEquals(50, acct.getBalance());
            }

            @Test
            @DisplayName("debit = balance")
            void testDebt_NoOverdraftProtection_DebtEQBalance() {
                BankAccount acct = new BankAccount(100, 0);
                boolean success = acct.debt(100);
                assertTrue(success);
                assertEquals(0, acct.getBalance());
            }

            @Test
            @DisplayName("debit > balance")
            void testDebt_NoOverdraftProtection_DebtGTBalance() {
                BankAccount acct = new BankAccount(100, 0);
                boolean success = acct.debt(110);
                assertFalse(success);
                assertEquals(100, acct.getBalance());
            }

        }

        @Nested
        @DisplayName("with overdraft protection")
        class WithOverdraftProtection {
            @Test
            @DisplayName("debit < balance with overdraft protection")
            void testDebt_WithOverdraftProtection_DebtLTBalancePLUSOverdraft() {
                BankAccount acct = new BankAccount(100, 20);
                boolean success = acct.debt(110);
                assertTrue(success);
                assertEquals(-10, acct.getBalance());
            }

            @Test
            @DisplayName("debit > balance with overdraft protection")
            void testDebt_WithOverdraftProtection_DebtGTBalancePLUSOverdraft() {
                BankAccount acct = new BankAccount(100, 20);
                boolean success = acct.debt(140);
                assertFalse(success);
                assertEquals(100, acct.getBalance());
            }

        }

    }
}