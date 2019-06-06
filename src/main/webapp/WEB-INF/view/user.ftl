<#import "/spring.ftl" as spring>
<#import  "tours.ftl" as tour>
<#include "common.ftl"/>
<@commonPage pageName = "User">
    <div class="col-12">
        <div class="panel">
            <section class="uui-image-text">
                <div class="image-section"
                     style="background-image: url(<@spring.url '/resources/images/tour-atitlan-background.jpg'/>)"></div>
                <div class="image-text-section">
                    <h3>User page</h3>
                </div>
            </section>
            <div class="uui-person-vertical-profile">
                <div class="person-profile-body">
                    <div class="person-profile-section">
                        <div class="person-profile-info">
                            <h2>${user.login}</h2>
                            <p>${user.role}</p>
                        </div>
                        <div class="person-profile-photo">
                            <img src="<@spring.url '/resources/uui/images/icons/no_photo.png'/>" alt=""/>
                        </div>
                    </div>
                </div>
                <div class="person-profile-footer">
                    <div class="person-profile-section">
                    </div>
                </div>
            </div>
        </div>
        <@tour.show tableName="User Tours"/>
        <div class="panel">
            <div class="row justify-content-center">
                <div class="col-8">
                    <h5>User Reviews :</h5>
                </div>
            </div>
            <table class="uui-table dynamic stripe records-per-page search showing-pages paging">
                <thead>
                <tr>
                    <th>Image</th>
                    <th>Country</th>
                    <th>Hotel name</th>
                    <th>Description</th>
                    <th>Mark</th>
                    <th>Date</th>
                </tr>
                </thead>
                <tbody>
                <#list reviews as review>
                    <tr>
                        <td><a href="<@spring.url '/tour/${review.tour.id}'/>"><img
                                        src="${review.tour.pathPhoto}"></a></td>
                        <td>
                            <a href="<@spring.url '/country/${review.tour.country.id}'/>">${review.tour.country.name}</a>
                        </td>
                        <td><a href="<@spring.url '/hotel/${review.tour.hotel.id}'/>">${review.tour.hotel.name}</a></td>
                        <td><h6>${review.text}</h6></td>
                        <td><h6>${review.mark}</h6></td>
                        <td><h6>${review.date}</h6></td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</@commonPage>


