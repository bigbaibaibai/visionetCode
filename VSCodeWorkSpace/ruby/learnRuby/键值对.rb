#哈希
xiaoming = {
    "name" => "小明",
    "age" => 18,
    "sex" => "男"
}

puts xiaoming
puts "name：" + xiaoming["name"]
puts "age：" + xiaoming["age"].to_s
puts "sex：" + xiaoming["sex"]

puts "-----------"

#类似json的使用，常用
xiaohong = {
    name: "小红",
    age: 18,
    sex: "女"
}
puts xiaohong 
puts "name：" + xiaohong[:name]
puts "age：" + xiaohong[:age].to_s
puts "sex：" + xiaohong[:sex]
