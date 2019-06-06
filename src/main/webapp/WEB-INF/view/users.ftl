<#import "/spring.ftl" as spring>
<#include "common.ftl"/>
<@commonPage pageName = "Users">
    <div class="col-12">
        <div class="panel">
            <table class="uui-table dynamic stripe records-per-page search showing-pages paging">
                <thead>
                <tr>
                    <th>id</th>
                    <th>login</th>
                    <th>Role</th>
                </tr>
                </thead>
                <tbody>
                <#list users as user>
                    <tr>
                        <td><a href="<@spring.url '/user/${user.id}'/>">${user.id}</a></td>
                        <td>${user.login}</td>
                        <td>${user.role}</td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</@commonPage>
