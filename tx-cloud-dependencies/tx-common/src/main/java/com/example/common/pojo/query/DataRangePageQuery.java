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
public class DataRangePageQuery extends PageQuery{

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
        if (orgIds == null && orgIdArray == null) {
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
        if (headquartersIds == null && headquartersIdArray == null) {
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

    public List<Long> getBidSectionIdArray() {
        if (bidSectionIds == null && bidSectionIdArray == null) {
            bidSectionIds = WebUtil.getRequest().getHeader("bidsectionidarray");
            String[] orgListTemp = bidSectionIds == null ? new String[0] : bidSectionIds.split(",");
            bidSectionIdArray = new ArrayList<>(orgListTemp.length);
            for (String orgId : orgListTemp) {
                try {
                    bidSectionIdArray.add(Long.parseLong(orgId));
                } catch (Exception e) {

                }
            }
        }
        return bidSectionIdArray;
    }

    public List<Long> getBranchIdArray() {
        if (branchIds == null && branchIdArray == null) {
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
        if (projectIds == null && projectIdArray == null) {
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

    public List<Long> getTeamIdArray() {
        if (teamIds == null && CollectionUtils.isEmpty(teamIdArray)) {
            teamIds = WebUtil.getRequest().getHeader("teamidarray");
            String[] orgListTemp = teamIds == null ? new String[0] : teamIds.split(",");
            teamIdArray = new ArrayList<>(orgListTemp.length);
            for (String orgId : orgListTemp) {
                try {
                    teamIdArray.add(Long.parseLong(orgId));
                } catch (Exception e) {

                }
            }
        }
        return teamIdArray;
    }

    public Boolean getPlatform() {
        if (isPlatformStr == null && isPlatform == null) {
            try {
                isPlatformStr = WebUtil.getRequest().getHeader("isplatform");
                isPlatform = Boolean.parseBoolean(isPlatformStr);
            } catch (Exception e) {
                isPlatform = false;
            }

        }
        return isPlatform;
    }

    public Boolean getHasDataRange() {
        if (hasDataRangeStr == null && hasDataRange == null) {
            try {
                hasDataRangeStr = WebUtil.getRequest().getHeader("hasdatarange");
                hasDataRange = Boolean.parseBoolean(hasDataRangeStr);
            } catch (Exception e) {
                hasDataRange = false;
            }

        }
        return hasDataRange;
    }
}
