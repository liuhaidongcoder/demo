#!/usr/bin/env bash

#预定信息
book_date=`date -v+5d +%Y-%m-%d`
book_theme='元数据统一项目'
star_time='20:00'
end_time='20:30'
meeting_id='184' #A1楼 三层 卖报歌
echo ${book_date}

#验证信息
gr_user_id='9f94bea9-aa6e-44d3-949e-65779df5d217'
SSO_SESSION_ID='ST-2716887-Trk3hq7dgupT2w9BNfa1-passport-58corp-com'

#预定请求
curl -b 'gr_user_id='+${gr_user_id}+';SSO_SESSION_ID=ST-2716887-Trk3hq7dgupT2w9BNfa1-passport-58corp-com;' \
-H "Content-Type: application/x-www-form-urlencoded; charset=UTF-8" \
-X POST \
-d 'theme='+${book_theme}+'&bookDate='+${book_date}+'&starTime=18:00&endTime=18:30&meetingid='+${meeting_id}+'&meetiongType=1&endBookDate=&userIds=' \
https://boa.58corp.com/meetingbook/saveNew


#data=`curl -b 'gr_user_id='+${gr_user_id}+';SSO_SESSION_ID=ST-2598555-ZIBvx72CDmpb6FKbehnp-passport-58corp-com;' \
# -H "Content-Type: application/x-www-form-urlencoded; charset=UTF-8" \
# -X POST \
# -d 'meetiongType=1&bookDate=2021-03-08&building=A1&storey=三层' \
# https://boa.58corp.com/meetingbook/list/ajax`

#echo $data | grep createDate