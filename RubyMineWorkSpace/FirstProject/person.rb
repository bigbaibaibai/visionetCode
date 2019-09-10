puts "hello world!"

class Person
  #共有静态属性
  PARAM = "param"
  #私有静态属性
  @@version = 1.0
  #私有普通属性
  @name = ""
  @age = 0

  def initialize(name, age)
    @name = name
    @age = age
  end

  def paramPuts
    puts "name：#{@name}"
    puts "age：#{@age}"
  end

  def self.show
    puts "I am a person"
  end

  def out
    puts "this is a method"
  end

end


class Student < Person

  def initialize(name, age, sex)
    #调用父类构造方法
    super(name, age)
    @sex = sex
  end

  def paramPuts
    #调用父类重载方法
    super
    puts "sex：#{@sex}"
    out
  end

end

xiaoming = Student.new("小明", 19, "男")

xiaoming.paramPuts

Student.show
