
package com.wbg.selenium.qa.services;

import java.util.ArrayList;
import java.util.List;

public class Input {
	public List<Value> getValue() {
		return value;
	}

	public void setValue(List<Value> value) {
		this.value = value; 
	}
	public List<Value> value = new ArrayList<Value>();
	

}
