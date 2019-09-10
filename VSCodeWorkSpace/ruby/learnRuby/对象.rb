#创建一个类
class Person
    #构造器
    def initialize(name = "小明")
       #@name表示实例变量，即对象属性
        @name = name
    end
    def showName
        puts "#{@name}"
    end
end

#创建一个对象
xiaoming = Person.new
#调用方法
xiaoming.showName

xiaohong = Person.new("小红")
xiaohong.showName

daming = Person.new("大明")
daming.showName