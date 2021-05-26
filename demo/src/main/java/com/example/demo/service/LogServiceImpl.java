package com.example.demo.service;

import net.minidev.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

@Service
public class LogServiceImpl implements LogService {

    public  String collectLogsFromFile()
    {
        HashMap<String,Integer> hashMap = new HashMap<String,Integer>();

        try{
            FileInputStream fstream = new FileInputStream("applications.log");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            /* read log line by line */
            while ((strLine = br.readLine())!=null)   {
                String[] parts = strLine.split(":");
                if(hashMap.containsKey(parts[0]))
                {
                    hashMap.put(parts[0],hashMap.get(parts[0])+1);
                }
                else {
                    hashMap.put(parts[0], 1);
                }

            }
            fstream.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        JSONObject json =  new JSONObject(hashMap);
        return json.toJSONString();

    }

}
