#!/usr/bin/env bash

#预定信息
book_date=`date -v+7d +%Y-%m-%d`
book_theme='元数据统一项目'
star_time='15:00'
end_time='15:30'
meeting_id='184' #A1楼 三层 卖报歌
echo ${book_date}

#验证信息
gr_user_id=''
SSO_SESSION_ID=''

#预定请求
curl -b 'gr_user_id='+${gr_user_id}+';SSO_SESSION_ID='+ ${SSO_SESSION_ID}+';' \
 -H "Content-Type: application/x-www-form-urlencoded; charset=UTF-8" \
 -X POST \
 -d 'theme='+${book_theme}+'&bookDate='+${book_date}+'&starTime=15:00&endTime=15:30&meetingid='+${meeting_id}+'&meetiongType=1&endBookDate=&userIds=' \
 https://boa.58corp.com/meetingbook/saveNew