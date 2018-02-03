package com.demo.nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Example1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("JavaScript");
		System.out.println(engine.getClass().getSimpleName());
		try {
			System.out.println("Result:" + engine.eval("function f() { return \"hello World\"};f();"));
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
