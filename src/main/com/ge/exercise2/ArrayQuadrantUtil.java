package com.ge.exercise2;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayQuadrantUtil {
    private static final Logger logger = LogManager.getLogger(ArrayQuadrantUtil.class);

    char[][] data;
    int rowNum=Integer.MAX_VALUE;
    int columnNum=Integer.MAX_VALUE;

    public ArrayQuadrantUtil(char[][] data) {
        this.data = data;
    }
    
    public char[] getRowData(int row) {
    	char[] charRow=new char[columnNum];
    	
    	for(int i=0;i<columnNum;i++) {
    		charRow[i]=data[row][i];
    	}
    	
		return charRow;
    	
    }
    
    public char[] getColumnData(int column) {
    	char[] charColumn=new char[rowNum];
    	
    	for(int i=0;i<rowNum;i++) {
    		charColumn[i]=data[i][column];
    	}
    	
		return charColumn;
    	
    }
    public char[] getQuadrantValues(int row, int column) {
    	List<Object> list=new ArrayList<>();
    	char[] ans=new char[Integer.MAX_VALUE];
    	int quadRow=row/2;
    	int quadColumn=column/2;
    	
    	list=check(row,column,quadRow,quadColumn);
    	for(int i=0;i<list.size();i++) {
    		ans[i]=(char) list.get(i);
    	}
    	
        return ans;
    }

	private List<Object> check(int row, int column, int quadRow, int quadColumn) {
		List<Object> list=new ArrayList<Object>();
		// TODO Auto-generated method stub
		if(row==0 && column==0) {
			for(int i =0;i<quadRow;i++) {
				for(int j=0;j<quadColumn;j++) {
					list.add(data[i][j]);
				}
			}
		}
		else if(row==0 && column==1) {
			for(int i =0;i<quadRow;i++) {
				for(int j=quadColumn;j<column;j++) {
					list.add(data[i][j]);
				}
			}
		}
		else if(row==1 && column==0) {
			for(int i =quadRow;i<row;i++) {
				for(int j=0;j<quadColumn;j++) {
					list.add(data[i][j]);
				}
			}
		}
		else if(row==1 && column==1) {
			for(int i =quadRow;i<row;i++) {
				for(int j=quadColumn;j<column;j++) {
					list.add(data[i][j]);
				}
			}
		}
		return list;
	}
}
