package com.example.common.pojo.query;
import com.example.common.utils.WebUtil;
import lombok.Data;
import org.springframework.util.CollectionUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * 登录用户能看到哪些数据
 *
 * @author xutu
 * @since 2022-06-27
 */
@Data
public class DataRangeQuery {

    private String orgIds = null;

    private String headquartersIds = null;

    private String bidSectionIds = null;

    private String branchIds = null;

    private String projectIds = null;

    private String workTypeIds = null;

    private String teamIds = null;

    private String isPlatformStr = null;

    private String hasDataRangeStr = null;

    /**
     * 机构id
     */
    private List<Long> orgIdArray;
    /**
     * 指挥部id
     */
    private List<Long> headquartersIdArray;
    /**
     * 标段id
     */
    private List<Long> bidSectionIdArray;
    /**
     * 分部id
     */
    private List<Long> branchIdArray;
    /**
     * 项目id
     */
    private List<Long> projectIdArray;
    /**
     * 工区id
     */
    private List<Long> workAreaIdArray;
    /**
     * 班组id
     */
    private List<Long> teamIdArray;
    /**
     * 是否是总平台用户
     * true:是
     */
    private Boolean isPlatform;
    /**
     * 是否有数据范围
     * true:有,false:无
     * 如果为false，则需要直接返回空集合，切记不可返回所有数据
     */
    private Boolean hasDataRange;

    public List<Long> getOrgIdArray() {
        if (orgIds == null && CollectionUtils.isEmpty(orgIdArray)) {
            orgIds = WebUtil.getRequest().getHeader("orgidarray");
            String[] orgListTemp = orgIds == null ? new String[0] : orgIds.split(",");
            orgIdArray = new ArrayList<>(orgListTemp.length);
            for (String orgId : orgListTemp) {
                try {
                    orgIdArray.add(Long.parseLong(orgId));
                } catch (Exception e) {

                }
            }
        }
        return orgIdArray;
    }

    public List<Long> getHeadquartersIdArray() {
        if (headquartersIds == null && CollectionUtils.isEmpty(headquartersIdArray)) {
            headquartersIds = WebUtil.getRequest().getHeader("headquartersidarray");
            String[] orgListTemp = headquartersIds == null ? new String[0] : headquartersIds.split(",");
            headquartersIdArray = new ArrayList<>(orgListTemp.length);
            for (String orgId : orgListTemp) {
                try {
                    headquartersIdArray.add(Long.parseLong(orgId));
                } catch (Exception e) {

                }
            }
        }
        return headquartersIdArray;
    }


    public List<Long> getBranchIdArray() {
        if (branchIds == null && CollectionUtils.isEmpty(branchIdArray)) {
            branchIds = WebUtil.getRequest().getHeader("branchidarray");
            String[] orgListTemp = branchIds == null ? new String[0] : branchIds.split(",");
            branchIdArray = new ArrayList<>(orgListTemp.length);
            for (String orgId : orgListTemp) {
                try {
                    branchIdArray.add(Long.parseLong(orgId));
                } catch (Exception e) {

                }
            }
        }
        return branchIdArray;
    }

    public List<Long> getProjectIdArray() {
        if (projectIds == null && CollectionUtils.isEmpty(projectIdArray)) {
            projectIds = WebUtil.getRequest().getHeader("projectidarray");
            String[] orgListTemp = projectIds == null ? new String[0] : projectIds.split(",");
            projectIdArray = new ArrayList<>(orgListTemp.length);
            for (String orgId : orgListTemp) {
                try {
                    projectIdArray.add(Long.parseLong(orgId));
                } catch (Exception e) {

                }
            }
        }
        return projectIdArray;
    }

    public List<Long> getWorkAreaIdArray() {
        if (workTypeIds == null && CollectionUtils.isEmpty(workAreaIdArray)) {
            workTypeIds = WebUtil.getRequest().getHeader("workareaidarray");
            String[] orgListTemp = workTypeIds == null ? new String[0] : workTypeIds.split(",");
            workAreaIdArray = new ArrayList<>(orgListTemp.length);
            for (String orgId : orgListTemp) {
                try {
                    workAreaIdArray.add(Long.parseLong(orgId));
                } catch (Exception e) {

                }
            }
        }
        return workAreaIdArray;
    }


}
