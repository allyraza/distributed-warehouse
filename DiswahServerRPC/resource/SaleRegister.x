program SalesRegister{
	version v1 {
		string registerSale(string)=1;
		string findSale(Long)=2;
		string list(void)=3;
		string delete(Long)=4;
	} = 1;
} = 1;