<template>
  <div class="container">
    <div class="row">
      <div class="col-8">
        <form>
          <div class="form-row">
            <h2>Shipping Address</h2>
          </div>
          <div class="form-group">
            <label for="shippingAddress">Address</label>
            <input type="text" class="form-control" id="shippingAddress" placeholder="1234 Main St" v-model="ship.address"/>
          </div>
          <div class="form-group">
            <label for="shippingAddress2">Address 2</label>
            <input
              type="text"
              class="form-control"
              id="shippingAddress2"
              placeholder="Apartment, studio, or floor"
              v-model="ship.address2"
            />
          </div>
          <div class="form-row">
            <div class="form-group col-md-6">
              <label for="shippingCity">City</label>
              <input type="text" class="form-control" id="shippingCity" v-model="ship.city"/>
            </div>
            <div class="form-group col-md-4">
              <label for="shippingState">State</label>
              <select id="shippingState" class="form-control" v-model="ship.state">
                <option value selected>Choose...</option>
                <option value="MI">MI</option>
                <option value="OH">OH</option>
                <option value="PA">PA</option>
              </select>
            </div>
            <div class="form-group col-md-2">
              <label for="shippingZip">Zip</label>
              <input type="text" class="form-control" id="shippingZip" v-model="ship.zip"/>
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-4">
              <label for="deliverto">Deliver Package to:</label>
              <div class="form-check" >
                <input
                  class="form-check-input"
                  type="radio"
                  name="deliverto"
                  id="delivertoFrontDoor"
                  value="Front Door"
                  checked
                  v-model="ship.deliverTo"
                />
                <label class="form-check-label" for="delivertoFrontDoor">Front Door</label>
              </div>
              <div class="form-check">
                <input
                  class="form-check-input"
                  type="radio"
                  name="deliverto"
                  id="delivertoSideDoor"
                  value="Side Door"
                  v-model="ship.deliverTo"
                />
                <label class="form-check-label" for="delivertoSideDoor">Side Door</label>
              </div>
              <div class="form-check">
                <input
                  class="form-check-input"
                  type="radio"
                  name="deliverto"
                  id="delivertoBackDoor"
                  value="Back Door"
                  v-model="ship.deliverTo"
                />
                <label class="form-check-label" for="delivertoBackDoor">Back Door</label>
              </div>
            </div>
          </div>

          <div class="billing-add">
            <div class="form-row">
              <h2>Billing Address</h2>
            </div>
            <div class="form-group">
              <label for="billingAddress">Address</label>
              <input
                type="text"
                class="form-control"
                id="billingAddress"
                placeholder="1234 Main St"
                v-model="bill.address"
              />
            </div>
            <div class="form-group">
              <label for="billingAddress2">Address 2</label>
              <input
                type="text"
                class="form-control"
                id="billingAddress2"
                placeholder="Apartment, studio, or floor"
                v-model="bill.address2"
              />
            </div>
            <div class="form-row">
              <div class="form-group col-md-6">
                <label for="billingCity">City</label>
                <input type="text" class="form-control" id="billingCity" v-model="bill.city"/>
              </div>
              <div class="form-group col-md-4">
                <label for="billingState">State</label>
                <select id="billingState" class="form-control" v-model="bill.state">
                  <option value selected>Choose...</option>
                  <option value="MI">MI</option>
                  <option value="OH">OH</option>
                  <option value="PA">PA</option>
                </select>
              </div>
              <div class="form-group col-md-2">
                <label for="billingZip">Zip</label>
                <input type="text" class="form-control" id="billingZip" v-model="bill.zip"/>
              </div>
            </div>
          </div>

          <button type="submit" class="btn btn-primary float-right">Next Step</button>
        </form>
      </div>
      <div class="col">
        <div class="results">
          <h3>Shipping Address</h3>
          <div class="line-item">
            Address:
            <span class="shipping-address">{{ship.address}}</span>
          </div>
          <div class="line-item">
            Address 2:
            <span class="shipping-address2">{{ship.address2}}</span>
          </div>
          <div class="line-item">
            City:
            <span class="shipping-city">{{ship.city}}</span>
          </div>
          <div class="line-item">
            State:
            <span class="shipping-state">{{ship.state}}</span>
          </div>
          <div class="line-item">
            Zip:
            <span class="shipping-zip">{{ship.zip}}</span>
          </div>
          <div class="line-item">
            Deliver to:
            <span class="shipping-deliverto">{{ship.deliverTo}}</span>
          </div>

          <h3>Billing Address</h3>
          <div class="line-item">
            Address:
            <span class="billing-address">{{bill.address}}</span>
          </div>
          <div class="line-item">
            Address 2:
            <span class="billing-address2">{{bill.address2}}</span>
          </div>
          <div class="line-item">
            City:
            <span class="billing-city">{{bill.city}}</span>
          </div>
          <div class="line-item">
            State:
            <span class="billing-state">{{bill.state}}</span>
          </div>
          <div class="line-item">
            Zip:
            <span class="billing-zip">{{bill.zip}}</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "address-info",
  data() {
    return {ship: {
        address: "",
        address2: "",
        city: "",
        state: "",
        zip: "",
        deliverTo: ""
      },
      bill: {
        address: "",
        address2: "",
        city: "",
        state: "",
        zip: ""
      }
    };
  }
};
</script>

<style>
.results {
  background-color: rgb(231, 231, 231);
  height: 100%;
  border-radius: 10px;
  padding: 10px;
}
.results h3:not(:first-child) {
  margin-top: 20px;
}
</style>
