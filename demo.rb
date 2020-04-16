# 打印好看的字符串
def print_str(str)
  arra=str.split(" ")
  max=0
  i=0
  for a in arra
  	array2[i]=a.to_s.split()
  	p array2[i]
  	i=i+1
    if max<a.size()
      max=a.size()
    end
  end
     
  p arra
  p max

 
  # 规范字符串的高度和宽度
  width=max+4
  height=arra.size()
  # 打印第一行
  x=1
  while x<=width
  puts "*"
  end
  # 打印字符串部分
  y=0
  j=0
  while y<height
  	xy=0
    while xy<width
      if xy==0
        puts "*"
      elsif xy==1
        puts " "
      elsif xy>(array2[j].size()+2)
        puts " "
      elsif xy==width-1
        puts "*"
      else 
        puts array2[j][xy]
      end
      xy=xy+1
    end
    j=j+1
  end
  # 打印最后一行
  x=1
  while x<=width
  puts "*"
  end

end

print_str("ai is good")