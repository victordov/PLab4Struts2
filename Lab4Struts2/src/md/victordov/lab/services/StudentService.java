package md.victordov.lab.services;

import java.util.ArrayList;
import java.util.List;

import md.victordov.lab.common.exception.MyDaoException;
import md.victordov.lab.dao.StudentDAO;
import md.victordov.lab.view.model.StudentModel;
import md.victordov.lab.vo.Student;

public class StudentService implements GenericService<StudentModel, Student> {
	
	private StudentDAO gDao = new StudentDAO();
	
	@Override
	public List<StudentModel> retrieve() throws MyDaoException {
		

		return this.transformList(gDao.retrieve());
	}

	@Override
	public List<StudentModel> retrieve(Integer start, Integer maxRecords)
			throws MyDaoException {
		
		return this.transformList(gDao.retrieve(start, maxRecords));
	}

	@Override
	public StudentModel retrieve(Integer id) throws MyDaoException {
		
		return this.transform(gDao.retrieve(id));
	}

	@Override
	public boolean create(StudentModel t) throws MyDaoException {
		
		return gDao.create(this.transformBack(t));

	}

	@Override
	public boolean update(StudentModel t) throws MyDaoException {
		
		return gDao.update(this.transformBack(t));

	}

	@Override
	public boolean delete(Integer id) throws MyDaoException {
		
		gDao.delete(id);
		return true;

	}

	@Override
	public Long countSize() throws MyDaoException {
		
		return gDao.countSize();
	}

	@Override
	public List<StudentModel> transformList(List<Student> r) {
		List<StudentModel> studentModelList = new ArrayList<StudentModel>();
		for (Student s : r) {
			StudentModel studentModelTemp = new StudentModel();
			studentModelTemp.setSId(s.getSId() != null? s.getSId() : -1);
			studentModelTemp.setNume(s.getNume());
			studentModelTemp.setPrenume(s.getPrenume());
			studentModelTemp.setGrupa(s.getGrupa());
			studentModelTemp.setEmail(s.getEmail());
			studentModelTemp.setTelFix(s.getTelFix());

			studentModelList.add(studentModelTemp);
		}
		return studentModelList;
	}

	@Override
	public StudentModel transform(Student s) {

		StudentModel studentModel = new StudentModel();

		studentModel.setSId(s.getSId());
		studentModel.setNume(s.getNume());
		studentModel.setPrenume(s.getPrenume());
		studentModel.setGrupa(s.getGrupa());
		studentModel.setEmail(s.getEmail());
		studentModel.setTelFix(s.getTelFix());

		return studentModel;
	}

	@Override
	public Student transformBack(StudentModel t) {

		Student student = new Student();

		student.setSId(t.getSId());
		student.setNume(t.getNume());
		student.setPrenume(t.getPrenume());
		student.setGrupa(t.getGrupa());
		student.setEmail(t.getEmail());
		student.setTelFix(t.getTelFix());

		return student;
	}
}
