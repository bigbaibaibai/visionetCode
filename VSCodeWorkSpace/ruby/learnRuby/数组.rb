#定义一个数组
array = ["小红" ,"小黄" ,"小花"]
#打印数组
puts array
puts "-------------------"

#遍历数组
array.each do |name|
    puts "你好，#{name}"
end
puts "-------------------"

#遍历数组加索引，索引下标从0开始
array.each_with_index do |name,i|
    puts "#{i} - #{name}"
end
puts "-------------------"

#把数组转化成一行字符串，用指定字符分隔
puts array.join(",")
