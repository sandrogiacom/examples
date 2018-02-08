package com.fluig.assist.demo;

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
		Text text = new Text();
		System.out.println("[Application - Main] Value passed to text display: " + value);
		text.display(value);
		System.out.println("[Application - Main] Complete application");
	}

}