cache = [0,1,1,]

def fibo(n):
	if (len(cache) > n):
		num = cache[n]
		return num
	else:
		num = fibo(n-1) + fibo(n-2)
		if (len(cache) <= n):
			cache.append(num)
		return num

while (True):
	userInput = raw_input("Input a positive integer (to find the nth term) or 'q' to quit: ")
	if (userInput == "q"):
		break
	else:
		num = ""
		try:
			num = int(userInput)
		except:
			print "Your input should be a positive integer (whole number).",
			
		if (num != ""):
			if (num > 0):
				print fibo(num)
			else:
				print "Your input should be a positive (greater than 0) integer.",