package com.babynorth.base.action;

import com.babynorth.action.BaseAction;
import org.apache.struts2.config.ParentPackage;

/**
 * Created by zhengbei on 2017/2/17.
 */

public class TestAction extends BaseAction {

    public String test() throws Exception {
        return "success";
    }
}
