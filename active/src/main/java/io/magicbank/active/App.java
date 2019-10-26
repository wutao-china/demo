package io.magicbank.active;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

import java.util.List;

public class App
{
    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
    /**
     * 部署流程定义
     */
    @Test
    public void deployment() {
        Deployment deployment = processEngine.getRepositoryService()//与流程定义和部署相关的Service
                .createDeployment()//创建一个部署对象
                .name("demoProcess")//添加部署的名称
                .addClasspathResource("MyProcess.bpmn")//从classpath下加载资源，一次一个
                .deploy();//完成部署
        System.out.println("部署ID"+deployment.getId());//1
        System.out.println("部署名称"+deployment.getName());
    }

    /**
     *启动流程实例
     */
    @Test
    public void startProcessInstance() {
        String processDefinitionKey = "myProcess";
        ProcessInstance processInstance = processEngine.getRuntimeService()//与正在执行的流程实例和执行对象相关的Service
                .startProcessInstanceByKey(processDefinitionKey);//根据Key值来查询流程,也可以根据ID
        System.out.println("流程实例ID:"+processInstance.getId());  //2501
        //对应数据库act_ru_execution
        System.out.println("流程定义ID:"+processInstance.getProcessDefinitionId()); //helloword:1:4
        //对应数据库act_re_deployment
    }

    /**
     * 查询当前个人的任务
     */
    @Test
    public void fingByPerson() {
        String assignee = "user1";
        List<Task> list = processEngine.getTaskService()//与正在执行的任务管理相关的Service
                .createTaskQuery()//创建任务查询对象
                .taskAssignee(assignee)//指定个人任务查询，指定代理人
                .list();//以list形式记录对象
        if(list != null && list.size()>0) {
            for(Task task:list) {
                System.out.println("任务ID:"+task.getId());//22504
                System.out.println("任务名称："+task.getName());//提交申请
                System.out.println("任务的创建时间："+task.getCreateTime());//：Wed Nov 14 17:02:43 CST 2018
                System.out.println("任务的代理人："+task.getAssignee());//staff1
                System.out.println("流程实例ID："+task.getProcessInstanceId());//22501
                System.out.println("执行对象ID："+task.getExecutionId());//22501
                System.out.println("流程定义ID："+task.getProcessDefinitionId());//demoProcess:1:20004
            }
        }
    }

    /**
     * 完成个人任务
     */
    @Test
    public void complete() {
        String taskId = "32508";
        processEngine.getTaskService()
        .complete(taskId );
        System.out.println("完成任务ID："+taskId);
    }

}