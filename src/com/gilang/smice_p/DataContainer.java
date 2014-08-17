package com.gilang.smice_p;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class DataContainer {

	@SerializedName(value = "Andromeda")
	private List<Data> datas;
	
	public DataContainer() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Data> getData(){
		return datas;
	}

}
