a = "hello"
b = "小红"
c = " "

#字符串拼接
puts a + c + b #hello 小红

#字符串带入，拼接字符串，并把新字符串赋值到第一个变量，后面的字符串不会发生改变
a << c << b
puts a   #hello 小红

#字符串乘法
puts (a + "\n") * 3  #把a换行输出三遍