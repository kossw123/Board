function checkUser()
{
	var elMsg = document.getElementById('Feedback');
	var elUserName = document.getElementById('UserName');
	if(elUserName.value.length<5)
	{
		elMsg.textContent = 'The id you entered must be at least 5 characters';
	}
	else
		{
			elMsg.textContent='';
		}
}