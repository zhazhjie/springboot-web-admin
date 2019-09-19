
package com.web.admin.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Map;

@Getter
@Setter
@ToString
public class PageWrapper<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int current = 1;

    private int size = 10;

    private Page<T> page;

    public PageWrapper() {

    }

    public PageWrapper(Map<String, Object> params) {
        if (params.get("current") != null) {
            current = Integer.parseInt((String) params.get("current"));
        }
        if (params.get("size") != null) {
            size = Integer.parseInt((String) params.get("size"));
        }
        this.page=new Page<T>(current,size);
    }
    public Page<T> getPage(){
        return this.page;
    }
}
