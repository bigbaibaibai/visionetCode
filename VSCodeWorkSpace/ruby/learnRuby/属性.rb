class Person
    attr_accessor :name, :age
    def initialize(name , age , sex)
        @name = name
        @age = age
        @sex = sex
    end
    def show
        puts "name:#{name}"
        puts "age:#{age}"
        puts "sex:#{sex}"
    end
end

lucy = Person.new("lucy",23,"男")

puts lucy.name
puts lucy.age
#这里会报错，因为attr_accessor中为定义sex属性
puts lucy.sex