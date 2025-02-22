package test.dao;

import dao.report.ReportDAOImpl;
import model.Report;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReportDAOTest {
    ReportDAOImpl reportDAO = new ReportDAOImpl();
    private Report report;

    @BeforeEach
    public void setUp(){
        report = new Report();
    }

    @AfterEach
    public void clearDAO(){
        reportDAO.delete(report);
    }

    @Test
    public void testSaveReport(){
        Report saveReport = reportDAO.save(report);
        Report expectedReport = reportDAO.getReport();

        assertEquals(expectedReport, saveReport);
    }

    @Test
    public void testDeleteReport(){
        reportDAO.save(report);
        reportDAO.delete(report);
        Report actualReport = reportDAO.getReport();

        assertNotSame(report, actualReport);
    }
}
