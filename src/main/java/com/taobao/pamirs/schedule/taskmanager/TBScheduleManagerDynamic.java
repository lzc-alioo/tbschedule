//package com.taobao.pamirs.schedule.taskmanager;
//
//import com.taobao.pamirs.schedule.TaskItemDefine;
//import com.taobao.pamirs.schedule.strategy.TBScheduleManagerFactory;
//
//import java.util.List;
//
///**
// * 暂未实现
// */
//public class TBScheduleManagerDynamic extends TBScheduleManager {
//    //private static transient Log log = LogFactory.getLog(TBScheduleManagerDynamic.class);
//
//    TBScheduleManagerDynamic(TBScheduleManagerFactory aFactory,
//                             String baseTaskType, String ownSign, int managerPort,
//                             String jxmUrl, IScheduleDataManager aScheduleCenter) throws Exception {
//        super(aFactory, baseTaskType, ownSign, aScheduleCenter);
//    }
//
//    public void initial() throws Exception {
//        if (scheduleTaskManager.isLeader(this.scheduleServer.getUuid(),
//                scheduleTaskManager.loadScheduleServerNames(this.scheduleServer.getTaskType()))) {
//            // 是第一次启动，检查对应的zk目录是否存在
//            this.scheduleTaskManager.initialRunningInfo4Dynamic(this.scheduleServer.getBaseTaskType(),
//                    this.scheduleServer.getOwnSign());
//        }
//        computerStart();
//    }
//
//    public void refreshScheduleServerInfo() throws Exception {
//        throw new Exception("没有实现");
//    }
//
//    public boolean isNeedReLoadTaskItemList() throws Exception {
//        throw new Exception("没有实现");
//    }
//
//    public void assignScheduleTask() throws Exception {
//        throw new Exception("没有实现");
//
//    }
//
//    public List<TaskItemDefine> getCurrentScheduleTaskItemList() {
//        throw new RuntimeException("没有实现");
//    }
//
//    public int getTaskItemCount() {
//        throw new RuntimeException("没有实现");
//    }
//}
