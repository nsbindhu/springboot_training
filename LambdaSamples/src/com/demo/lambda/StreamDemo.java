package com.demo.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class StreamDemo {
	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("ankit");
		names.add("raju");
		names.add("poonam");
		names.add("kirti");
		names.add("romel");
		names.add("karan");
		names.add("chundi");
		names.add("ramesh");
		names.add("charan");
		names.add("babu");
		
		List<String> filteredList = new ArrayList<>(); 
		List<String> filteredList1 = new ArrayList<>(); 

		for(String name:names) {
			if(name.startsWith("r")) {
				filteredList.add(name);
			}
		}
		System.out.println("Total : "+filteredList.size());
		for(String name:filteredList) {
			System.out.println(name);
		}
		System.out.println("\n");
		//Java8
	    names.stream().filter(name-> name.startsWith("c")).forEach(e->{filteredList1.add(e);System.out.println(e);});	
		System.out.println("\n"+filteredList1.size());

	    Predicate<String> p1 = s->s.startsWith("k");
	    Consumer<String> c1 = c->System.out.println(c);
	    
	    names.stream().filter(p1).forEach(c1);	
	    
	}
}
