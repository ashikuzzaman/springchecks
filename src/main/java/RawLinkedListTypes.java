package com.github.ashikuzzaman.javaapichecks.spring;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import com.github.ashikuzzaman.javaapichecks.collections.LinkedNode;

@RestController
@EnableAutoConfiguration
public class RawLinkedListTypes {

    @RequestMapping("/")
    String home() {
	String runtimeArg = "sort";
	StringBuilder sb = new StringBuilder("<b>How To Build a Custom Linked List without taking help of Java Collections API</b><br><br>");

        int length = 10;
        LinkedNode myNode = new LinkedNode(length); // head
        LinkedNode nodeToRemove = null;
	String tempStr = "<br>Node starts at  = " + myNode.data;
	sb.append(tempStr);
        System.out.println(tempStr);
        for(int i=length-1; i>0; i--){
            myNode = myNode.insert(myNode, i);
            if(i == 5) {
                nodeToRemove = myNode;
            }
	    tempStr = "<br>during insert myNode.data for " + i + " = " + myNode.data;
	    sb.append(tempStr);
            System.out.println(tempStr);
        }
	if("sort".equalsIgnoreCase(runtimeArg)) {
		myNode = myNode.insertSorted(myNode, 7); 
	} else if ("find".equalsIgnoreCase(runtimeArg)) {
		LinkedNode foundNode = myNode.find(myNode, 8);
		tempStr = "<br>Searched and found the node for " + foundNode.data;
		sb.append(tempStr);
		System.out.println(tempStr);
	} else if ("remove".equalsIgnoreCase(runtimeArg)) {
		LinkedNode removeddNode = myNode.remove(myNode, nodeToRemove);
		tempStr = "<br>Removed the node for " + removeddNode.data;
		sb.append(tempStr);
		System.out.println(tempStr);
	} else {
		myNode = myNode.insert(myNode, 7);
	}

        while(myNode != null) {
	    tempStr = "<br>after insertion done, myNode.data for " + " = " + myNode.data;
	    sb.append(tempStr);
	    System.out.println(tempStr);
            myNode = myNode.next;
        }

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(RawLinkedListTypes.class, args);
    }

}
