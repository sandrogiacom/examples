package com.fluig.agent.demo;

import javassist.CannotCompileException;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;

public class DemoExpressionEditor extends ExprEditor {
	@Override
	public void edit(MethodCall method) throws CannotCompileException {
		if (method.getMethodName().contains("sleep")) {
			System.out.println("[Instrumentation] Suppressing sleep for " + method.getClassName() + "."
					+ method.getMethodName() + " called from " + method.getEnclosingClass().getName());
			method.replace("{}");
		}
	}
}