package com.listeners;

import com.constants.FrameworkConstants;
import com.utils.ExcelUtils;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class MethodInterceptor implements IMethodInterceptor{

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

        List<Map<String, String>> list = null;
        List<IMethodInstance> results = new ArrayList<>();

        list = ExcelUtils.getTestDetails(FrameworkConstants.getRunmanagerDatasheet());


        for (int i = 0; i <methods.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("testname"))
                    && (list.get(j).get("execute").equalsIgnoreCase("yes"))){
                        methods.get(i).getMethod().setDescription(list.get(j).get("testdescription"));
                        methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("count")));
                        methods.get(i).getMethod().setPriority(Integer.parseInt(list.get(j).get("priority")));
                        results.add(methods.get(i));
                }
            }
        }

        return results;
    }
}
