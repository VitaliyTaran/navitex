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
                        <button class="uui-button"><a href="#popup2"
                                                      data-toggle="modal">asd</a</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-3">
        <div class="panel">
            <div class="row justify-content-center">
                <h4>Sensor</h4>
            </div>
            <div class="row  justify-content-center">
                <h4>co2 : </h4><input type="number" class="uui-form-element"/>
                <h4>co : <input type="number" class="uui-form-element"/></h4>
                <h4>lpg : <input type="number" class="uui-form-element"/></h4>
                <h4>dust : <input type="number" class="uui-form-element"/></h4>
                <h4>temp : <input type="number" class="uui-form-element"/></h4>
                <h4>pressure : <input type="number" class="uui-form-element"/></h4>
            </div>
            <div class="row justify-content-between">
                <div class="col"></div>
                <div class="col">
                    <button class="uui-button">Remove</button>
                </div>
                <div class="col">
                    <button class="uui-button">Cancel</button>
                </div>
                <div class="col">
                    <button class="uui-button">Update</button>
                </div>
                <div class="col"></div>
                <div>
                </div>
            </div>
            <style>
                #map {
                    height: 600px;
                }
            </style>

</@commonPage>