package br.furb.diswah.view;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.furb.diswah.model.BasicEntity;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class DefaultTableModel extends AbstractTableModel {

	private List<? extends BasicEntity> data;
	private Class<? extends BasicEntity> clazz;
	
	/**
	 * @param clazz
	 */
	public DefaultTableModel(Class<? extends BasicEntity> clazz){
		this.clazz = clazz;
		data = new ArrayList<BasicEntity>();
	}
	
	/**
	 * @param data
	 */
	public void refresh(List<? extends BasicEntity> data) {
		if(data != null){
			this.data = data;
			fireTableStructureChanged();
			fireTableDataChanged();
		}
	}

	@Override
	public Class<?> getColumnClass(int arg0) {
		return String.class;
	}

	@Override
	public int getColumnCount() {
		return clazz.getFields().length;
	}

	@Override
	public String getColumnName(int i) {
		return clazz.getFields()[i].getName();
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		Object instance = data.get(arg0);
		Field f = instance.getClass().getFields()[arg1];
		f.setAccessible(true);
		try {
			return String.valueOf(f.get(instance));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		return false;
	}

}