class Person
    def initialize(name ,age)
        @name = name
        @age = age
    end

    def show
        puts "name：#{@name}\nage：#{@age}"
    end

    #静态方法，只能通过类名调用
    def self.say
        puts "I am Person"
    end
end

class Student < Person
    