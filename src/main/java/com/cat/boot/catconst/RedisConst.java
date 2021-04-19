package com.cat.boot.catconst;

public class RedisConst {

	public static int token_db = 0;
	public static int namequery_db = 1;
	public static int path_db = 2;
	public static int reload_db = 3;
	
	public static String path_key = "path";
	public static String minio_path_key = "minio_path";
	public static String attence_date = "attence_date";
	public static String dict_id = "dict_id";
	public static String whitelist_key = "whitelist";
	public static String jiguang_push = "jiguang_push";

	public static String suhedule_code_prefix = "GD-YW";//项目跟进-项目编号前缀
	public static String aftersales_code_prefix = "SH-YW";//售后-售后编号前缀
	
	public static int EXPIRE_TIME = 60 *5;
	
}
