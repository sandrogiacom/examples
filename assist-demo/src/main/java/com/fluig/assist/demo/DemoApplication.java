package com.fluig.assist.demo;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.expr.ExprEditor;

/**
 * 
 * @author sandro
 * 
 * Rodar com argumento -noverify
 * 
 * https://stackoverflow.com/questions/31567532/getting-expecting-a-stackmap-frame-at-branch-target-when-running-maven-integra 
 *  
 */
public class DemoApplication {
	
	public static void main(String[] args) {
		System.out.println("[Application - Main] Start application");
		String value = "Demonstration of Java bytecode manipulation capabilities";
		enableInstrumentation();
		Text text = new Text();
		System.out.println("[Application - Main] Value passed to text display: " + value);
		text.display(value);
		System.out.println("[Application - Main] Complete application");
	}

	private static void enableInstrumentation() {
		String instrumentedClassName = "com.fluig.assist.demo.Text";
		String instrumentedMethodName = "display";
		String instrumentedMethodDescriptor = "(Ljava/lang/String;)V";
		try {
			ClassPool cPool = ClassPool.getDefault();
			CtClass ctClass = cPool.get(instrumentedClassName);
			CtMethod ctClassMethod = ctClass.getMethod(instrumentedMethodName, instrumentedMethodDescriptor);
			ctClassMethod.insertBefore("System.out.println(\"[Instrumentation] Entering instrumented method\");");
			ctClassMethod.insertAfter("System.out.println(\"[Instrumentation] Exiting instrumented method\");");
			ctClassMethod.insertAt(24, true, "text = \"Original text was replaced by instrumentation from agent\";");
			ExprEditor instrumentationExpressionEditor = new DemoExpressionEditor();
			ctClassMethod.instrument(instrumentationExpressionEditor);
			ctClass.toClass();
		} catch (NotFoundException e) {
			e.printStackTrace();
		} catch (CannotCompileException e) {
			e.printStackTrace();
		}
	}
}