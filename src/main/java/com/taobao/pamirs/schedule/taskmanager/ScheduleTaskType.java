package com.taobao.pamirs.schedule.taskmanager;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * 任务详细配置信息
 * @author xuannan
 *
 */
public class ScheduleTaskType implements java.io.Serializable {

    //
    private static final long serialVersionUID = 1L;

    //任务类型
    private String baseTaskType;

    //向配置中心更新心跳信息的频率(单位：s)
    private long heartBeatRate = 5 * 1000;//5秒

    //判断一个服务器死亡的周期。为了安全，至少是心跳周期的两倍以上(单位：s)
    private long judgeDeadInterval = 1 * 60 * 1000;//60秒

    //当没有数据的时候，休眠的时间(单位：s)
    private int sleepTimeNoData = 500;

    //在每次数据处理晚后休眠的时间(单位：s)
    private int sleepTimeInterval = 0;

    //每次获取数据的数量
    private int fetchDataNumber = 500;

    //在批处理的时候，每次处理的数据量(该参数仅对实现了IScheduleTaskDealMulti接口的任务有效)
    private int executeNumber = 1;

    //单线程组的线程数量
    private int threadNumber = 5;

    //调度器类型 取值枚举有：SLEEP,NOTSLEEP
    private String processorType = "SLEEP";

    //允许执行的开始时间(Quartz表达式规则)
    private String permitRunStartTime;

    //允许执行的开始时间(Quartz表达式规则)，可为空
    private String permitRunEndTime;

    //清除过期环境信息的时间间隔（单位：天）
    private double expireOwnSignInterval = 1;

    //处理任务的BeanName
    private String dealBeanName;

    //任务bean的参数，由用户自定义格式的字符串
    private String taskParameter;

    //任务类型：静态static,动态dynamic
    private String taskKind = TASKKIND_STATIC;

    public static String TASKKIND_STATIC = "static";
    public static String TASKKIND_DYNAMIC = "dynamic";

    //任务项数组
    private String[] taskItems;

    //每个线程组能处理的最大任务项目项数量（已作废）
    @Deprecated
    private int maxTaskItemsOfOneThreadGroup = 0;

    //版本号
    private long version;

    //服务状态: pause,resume
    private String sts = STS_RESUME;

    public static String STS_PAUSE = "pause";
    public static String STS_RESUME = "resume";


    //    "0:{TYPE=A,KIND=1},1:{TYPE=A,KIND=2},2:{TYPE=A,KIND=3},3:{TYPE=A,KIND=4}," +
//    "4:{TYPE=A,KIND=5},5:{TYPE=A,KIND=6},6:{TYPE=A,KIND=7},7:{TYPE=A,KIND=8}," +
//    "8:{TYPE=A,KIND=9},9:{TYPE=A,KIND=10}"
    public static String[] splitTaskItem(String str) {
        List<String> list = new ArrayList<String>();
        int start = 0;
        int index = 0;
        while (index < str.length()) {
            if (str.charAt(index) == ':') {
                index = str.indexOf('}', index) + 1;
                list.add(str.substring(start, index).trim());
                while (index < str.length()) {
                    if (str.charAt(index) == ' ') {
                        index = index + 1;
                    } else {
                        break;
                    }
                }
                index = index + 1; //跳过逗号
                start = index;
            } else if (str.charAt(index) == ',') {
                list.add(str.substring(start, index).trim());
                while (index < str.length()) {
                    if (str.charAt(index) == ' ') {
                        index = index + 1;
                    } else {
                        break;
                    }
                }
                index = index + 1; //跳过逗号
                start = index;
            } else {
                index = index + 1;
            }
        }
        if (start < str.length()) {
            list.add(str.substring(start).trim());
        }
        return (String[]) list.toArray(new String[0]);
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public String getBaseTaskType() {
        return baseTaskType;
    }

    public void setBaseTaskType(String baseTaskType) {
        this.baseTaskType = baseTaskType;
    }

    public long getHeartBeatRate() {
        return heartBeatRate;
    }

    public void setHeartBeatRate(long heartBeatRate) {
        this.heartBeatRate = heartBeatRate;
    }

    public long getJudgeDeadInterval() {
        return judgeDeadInterval;
    }

    public void setJudgeDeadInterval(long judgeDeadInterval) {
        this.judgeDeadInterval = judgeDeadInterval;
    }

    public int getFetchDataNumber() {
        return fetchDataNumber;
    }

    public void setFetchDataNumber(int fetchDataNumber) {
        this.fetchDataNumber = fetchDataNumber;
    }

    public int getExecuteNumber() {
        return executeNumber;
    }

    public void setExecuteNumber(int executeNumber) {
        this.executeNumber = executeNumber;
    }

    public int getSleepTimeNoData() {
        return sleepTimeNoData;
    }

    public void setSleepTimeNoData(int sleepTimeNoData) {
        this.sleepTimeNoData = sleepTimeNoData;
    }

    public int getSleepTimeInterval() {
        return sleepTimeInterval;
    }

    public void setSleepTimeInterval(int sleepTimeInterval) {
        this.sleepTimeInterval = sleepTimeInterval;
    }

    public int getThreadNumber() {
        return threadNumber;
    }

    public void setThreadNumber(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    public String getPermitRunStartTime() {
        return permitRunStartTime;
    }

    public String getProcessorType() {
        return processorType;
    }

    public void setProcessorType(String processorType) {
        this.processorType = processorType;
    }

    public void setPermitRunStartTime(String permitRunStartTime) {
        this.permitRunStartTime = permitRunStartTime;
        if (this.permitRunStartTime != null && this.permitRunStartTime.trim().length() == 0) {
            this.permitRunStartTime = null;
        }
    }

    public String getPermitRunEndTime() {
        return permitRunEndTime;
    }

    public double getExpireOwnSignInterval() {
        return expireOwnSignInterval;
    }

    public void setExpireOwnSignInterval(double expireOwnSignInterval) {
        this.expireOwnSignInterval = expireOwnSignInterval;
    }

    public String getDealBeanName() {
        return dealBeanName;
    }

    public void setDealBeanName(String dealBeanName) {
        this.dealBeanName = dealBeanName;
    }

    public void setPermitRunEndTime(String permitRunEndTime) {
        this.permitRunEndTime = permitRunEndTime;
        if (this.permitRunEndTime != null && this.permitRunEndTime.trim().length() == 0) {
            this.permitRunEndTime = null;
        }

    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public void setTaskItems(String[] aTaskItems) {
        this.taskItems = aTaskItems;
    }

    public String[] getTaskItems() {
        return taskItems;
    }

    public void setSts(String sts) {
        this.sts = sts;
    }

    public String getSts() {
        return sts;
    }

    public void setTaskKind(String taskKind) {
        this.taskKind = taskKind;
    }

    public String getTaskKind() {
        return taskKind;
    }

    public void setTaskParameter(String taskParameter) {
        this.taskParameter = taskParameter;
    }

    public String getTaskParameter() {
        return taskParameter;
    }

    @Deprecated
    public int getMaxTaskItemsOfOneThreadGroup() {
        return maxTaskItemsOfOneThreadGroup;
    }

    @Deprecated
    public void setMaxTaskItemsOfOneThreadGroup(int maxTaskItemsOfOneThreadGroup) {
        this.maxTaskItemsOfOneThreadGroup = maxTaskItemsOfOneThreadGroup;
    }


}
