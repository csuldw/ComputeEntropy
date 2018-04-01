package com.zola.study.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.mysql.jdbc.StringUtils;
import com.zola.study.entity.FastaEntity;

public class Utils {

	private static Logger log = Logger.getLogger(Utils.class);

	/**
	 * 计算fasta
	 * 
	 * Author:liudiwei Date:2018年3月23日
	 * 
	 * @param fastaItem
	 * @return
	 * @since
	 */
	public static List<FastaEntity> getEntropyFromSeq(String fastaItem) {
		List<FastaEntity> fastaEntities = new ArrayList<>();
		String[] fastaList = fastaItem.split("\n");

		FastaEntity entity = new FastaEntity();
		for (String str : fastaList) {
			if (str.contains(">")) {
				entity.setName(str);
				continue;
			}
			//计算entropy
			entity.setSequence(str);
			
			if (entity != null && !StringUtils.isNullOrEmpty(entity.getName())
					&& !StringUtils.isNullOrEmpty(entity.getSequence())){
				fastaEntities.add(entity);
				entity = new FastaEntity();
			}
		}
		return fastaEntities;
	}

	public static void main(String[] args) {
		String fastaItem = ">1234\nATGCATCS\n>1234\nATGCATCS";
		List<FastaEntity> entities = Utils.getEntropyFromSeq(fastaItem);
		System.out.println(entities.toString());
	}
}
