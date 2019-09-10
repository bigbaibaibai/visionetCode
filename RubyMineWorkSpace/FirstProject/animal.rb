module Animal

  Version = 1.0

  def hello(name)
    "hello " + name
  end

  def self.run
    "我会跑"
  end

  def eat
    "我会吃"
  end

  module_function :eat

end

class Pig
  include Animal

end

puts Animal::run
puts Animal.run

puts Animal::Version
#错误写法 puts Animal.Version

puts Animal.eat
puts Animal::eat

#可调用模板静态属性，不能调用模板中的静态方法
puts Pig::Version

pig = Pig.new
puts pig.hello("小明")