def fibo(n):
	if (n==1 or n==2):
		return 1
	else:
		return fibo(n-1) + fibo(n-2)

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