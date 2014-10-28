def fibo(n):
	x, y = 0, 1
	for i in range(0,n):
		temp = x+y
		x = y
		y = temp
	return x

while (True):
	try:
		num = int(raw_input("Input a positive integer (to find the nth term): "))
		if (num > 0):
			break
		else:
			print "Your input should be a positive (greater than 0) integer",
	except:
		print "Your input should be a positive integer (whole number)",

print fibo(num)
raw_input("Press any key to exit...")