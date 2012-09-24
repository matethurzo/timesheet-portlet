package com.liferay.portlet.timesheet;

import com.liferay.faces.bridge.GenericLiferayFacesPortlet;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import java.io.IOException;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class TimesheetPortlet
 */
public class TimesheetPortlet extends GenericLiferayFacesPortlet {

    public void init() {
        viewJSP = getInitParameter("view-template");
    } 
    protected String viewJSP;

}
