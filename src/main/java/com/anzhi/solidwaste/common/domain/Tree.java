package com.anzhi.solidwaste.common.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author andy
 * @date 2019/7/2 14:02
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tree<T> {

    private String id;

    private String parentId;

    private String name;

    private String type;

    private String index;

    private List<Tree<T>> children;

    private List<Tree<T>> canDo;

    public void initChildren(){
        this.children = new ArrayList<>();
    }

    public void initCanDo(){
        this.canDo = new ArrayList<>();
    }
}