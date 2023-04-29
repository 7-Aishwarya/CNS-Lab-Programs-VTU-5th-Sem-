BEGIN{
drop=0;
}
{
 if($1=="d")
 drop++;
}
END{
printf("No of packets %s dropped =%d\n",$5,drop);
}
 
