package com.modcrafting.example;

import java.lang.reflect.Constructor;
import org.bukkit.plugin.java.JavaPlugin;

public class Example extends JavaPlugin{
	MasterInterface mi;
	@Override
	public void onEnable(){
		String p = this.getServer().getClass().getPackage().getName();
        String version = p.substring(p.lastIndexOf('.') + 1);
        if (version.equals("v1_5")){
        	//Sets the interface for 1.5 version of the class
        	mi = new V1_5Class(this);
        }else if (version.equals("v1_4_6")){
        	//Sets the interface for 1.4.6 version of the class
        	mi = new V1_4_6Class(this);
        }else if (version.equals("v1_4_5")){
        	//Sets the interface for 1.4.5 version of the class
        	mi = new V1_4_5Class(this);
        }else if (version.equals("craftbukkit")){
        	//Sets the interface for original version of the class
        	mi = new VPreClass(this);
        }else{
        	//Disables the plugin if quiry things happen.
			this.setEnabled(false);
        }
        
        //OR Using Reflection;
        try {
        	String classname = null;
        	if(version.contains("craftbukkit")){
        		classname = this.getClass().getPackage().getName()+".VPreClass";
        	}else{
        		classname = this.getClass().getPackage().getName()+".V"+version.substring(1)+"Class";
        	}
			Class<?> clazz = Class.forName(classname);
			Constructor<?> cons = clazz.getDeclaredConstructor(this.getClass());
			Object obj = cons.newInstance(this);
			if(obj instanceof MasterInterface){
				mi = (MasterInterface) obj;
			}
		} catch (Exception e) {
			this.setEnabled(false);
		}
	}
}
