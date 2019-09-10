#定义一个函数
def sayHello
    puts "hello"
end
#调用函数
sayHello

def sayHello(name)
    puts "hello #{name}"
end
sayHello("小明")

def sayHello(name = "小明")
    puts "hello #{name}"
end
sayHello