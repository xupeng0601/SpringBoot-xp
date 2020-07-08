package org.xp.example.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author xupeng
 * @Desc
 * @date 2020/7/8 11:05
 */
@Service
public class ExceptionService {

    public double getResult(int fz,int fm) {
        List<String> list = new ArrayList<String>();
        list.add("beijing");
        list.add("shanghai");
        list.add("shanghai");
        list.add("guangzhou");
        list.add("shenzhen");
        list.add("hangzhou");
        String target = "hangzhou";
//        int size = list.size();
        for(String item : list){
            if(target.equals(item)){
                list.remove(item);
            }
        }
        System.out.println(list);
        return (double)fm/fz;
    }

    public static void main(String[] args) {

    }
}
