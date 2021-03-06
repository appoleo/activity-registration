#!/bin/bash
profile=$1
index=$2
app_name=activity-registration-1.0-SNAPSHOT.jar
dir_path=/home/ami/server/activity-registration/

pid=`ps -ef | grep $app_name | grep index=$index | grep -v grep | awk '{print $2}'`
if [ -n "$pid" ]
then
  echo "kill -9 pid:" $pid
  kill -9 $pid
fi
echo 重启项目...
source /etc/profile
BUILD_ID=DONTKILLME
cd $dir_path
echo `pwd`
nohup java -server -Xms300m -Xmx300m -jar $app_name --index=$index --spring.profiles.active=$profile >/dev/null &2>&1 &
echo 重启完成...
