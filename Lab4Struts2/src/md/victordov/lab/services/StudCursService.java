package md.victordov.lab.services;

import java.util.ArrayList;
import java.util.List;

import md.victordov.lab.common.exception.MyDaoException;
import md.victordov.lab.dao.StudCursDAO;
import md.victordov.lab.view.model.StudCursModel;
import md.victordov.lab.vo.Curs;
import md.victordov.lab.vo.StudCurs;
import md.victordov.lab.vo.Student;

public class StudCursService implements GenericService<StudCursModel, StudCurs> {
	
	private StudCursDAO studCursDAO = new StudCursDAO();

	@Override
	public List<StudCursModel> retrieve() throws MyDaoException {
		
		return this.transformList(studCursDAO.retrieve());
	}

	@Override
	public List<StudCursModel> retrieve(Integer start, Integer maxRecords)
			throws MyDaoException {
		return this.transformList(studCursDAO.retrieve(start, maxRecords));
	}

	@Override
	public StudCursModel retrieve(Integer id) throws MyDaoException {
		return this.transform(studCursDAO.retrieve(id));
	}

	@Override
	public boolean create(StudCursModel t) throws MyDaoException {
		return studCursDAO.create(this.transformBack(t));
	}

	@Override
	public boolean update(StudCursModel t) throws MyDaoException {
		return studCursDAO.update(this.transformBack(t));
	}

	@Override
	public boolean delete(Integer id) throws MyDaoException {
		studCursDAO.delete(id);
		return true;

	}

	@Override
	public Long countSize() throws MyDaoException {
		return studCursDAO.countSize();
	}

	@Override
	public List<StudCursModel> transformList(List<StudCurs> sc) {
		List<StudCursModel> studCursModelList = new ArrayList<StudCursModel>();
		for (StudCurs c : sc) {
			StudCursModel studCursModelTemp = new StudCursModel();
			studCursModelTemp.setScId(c.getScId());

			studCursModelTemp.setStudentId(c.getStudent().getSId());
			studCursModelTemp.setStudentNume(c.getStudent().getNume() + " "
					+ c.getStudent().getPrenume());

			studCursModelTemp.setCursId(c.getCurs().getCId());
			studCursModelTemp.setCursNume(c.getCurs().getNumeCurs());

			studCursModelList.add(studCursModelTemp);
		}
		return studCursModelList;
	}

	@Override
	public StudCursModel transform(StudCurs sc) {
		StudCursModel studCursModel = new StudCursModel();
		studCursModel.setScId(sc.getScId());

		studCursModel.setStudentId(sc.getStudent().getSId());
		studCursModel.setStudentNume(sc.getStudent().getNume() + " "
				+ sc.getStudent().getPrenume());

		studCursModel.setCursId(sc.getCurs().getCId());
		studCursModel.setCursNume(sc.getCurs().getNumeCurs());
		return studCursModel;
	}

	@Override
	public StudCurs transformBack(StudCursModel t) {
		StudCurs sc = new StudCurs();
		Curs curs = new Curs();
		Student student = new Student();

		sc.setScId(t.getScId());

		curs.setCId(t.getCursId());
		sc.setCurs(curs);

		student.setSId(t.getStudentId());
		sc.setStudent(student);

		return sc;
	}

}
