<#import "/spring.ftl" as spring>
<#include "common.ftl">
<@commonPage pageName="Travel Agency">
    <div class="col-12">
        <div class="panel">
            <section class="uui-image-text">
                <div class="image-section"
                     style="background-image: url(<@spring.url '/resources/images/hotel-background.jpg'/>)"></div>
                <div class="image-text-section">
                    <h3>Map</h3>
                </div>
            </section>

            <div class="row justify-content-center">
                <div id="map" class="col-8">


                </div>
                <div class="col-4">
                    <div class="panel">
                        <h3>Change criteria</h3>
                        <select class="selectpicker uui-form-element">
                            <option>By cost</option>
                            <option>By distance</option>
                            <option>Mix</option>
                        </select>
                        <button class="uui-button">Calculate</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <style>
        #map {
            height: 600px;
        }
    </style>

</@commonPage>