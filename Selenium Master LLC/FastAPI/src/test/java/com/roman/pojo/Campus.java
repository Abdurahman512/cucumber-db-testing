package com.roman.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Campus {

   private int id;
   private String location;

   @JsonProperty("clusters")
   private List<Cluster> clusterList;
}
