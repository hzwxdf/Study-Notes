def print_str(str)
  arra=str.split(" ")
  array2=[]
  max=0
  i=0
  for a in arra
    array2[i]=a.to_s
  	i=i+1
    if max<a.size()
      max=a.size()
    end
  end
  
  # 规范字符串的高度和宽度
  width=max+4
  height=arra.size()
  # 打印第一行
  x=1
  while x<=width
  p "*"
  x=x+1
  end
  # 打印字符串部分
  y=0
  j=0
  while y<height
    xy=0
    while xy<width
      if xy==0
        p "*"
      elsif xy==1
        p " "
      elsif xy>(array2[j].size()+2)
        p  " "
      elsif xy==width-1
        p "*"
        break
      else 
        p array2[j]
      end
      xy=xy+1
    end
    j=j+1
  end
  # 打印最后一行
  x=1
  while x<=width
  p "*"
  x=x+1
  end

end

print_str("ai is good")
p "-------"
p "90 token expire“
